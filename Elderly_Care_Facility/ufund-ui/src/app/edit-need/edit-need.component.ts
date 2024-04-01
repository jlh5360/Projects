import { Component } from '@angular/core';
import {Need} from '../need';
import {NeedsService} from '../needs.service';

@Component({
  selector: 'app-edit-need',
  templateUrl: './edit-need.component.html',
  styleUrls: ['./edit-need.component.scss']
})
export class EditNeedComponent {
  need: Need = {} as Need;

  isEditingNeed = false;
  isCreatingNeed = false;
  isSuccessful = false;

  constructor(private needsService: NeedsService) {}

  ngOnInit(): void {
    if (localStorage.getItem("isEditingNeed") == "true") {
      this.isEditingNeed = true;
    }
    if (localStorage.getItem("isCreatingNeed") == "true") {
      this.isCreatingNeed = true;
    }
    this.isSuccessful = false;
    var need = localStorage.getItem("editneed");
    if (need == null) {
      return;
    } else {
      this.need = JSON.parse(need);
    }
  }

  onEditNeed() {
    this.needsService.updateNeed(this.need)
      .subscribe(need => {
        this.isSuccessful = true;
        localStorage.setItem("editneed", JSON.stringify(need));
        return need
      });
  }

  onCreateNeed() {
    this.needsService.createNeed(this.need)
      .subscribe(need => {
        this.isSuccessful = true;
        return need;
      });

    // Reset need after submitting
    this.need = {} as Need;
  }


}
