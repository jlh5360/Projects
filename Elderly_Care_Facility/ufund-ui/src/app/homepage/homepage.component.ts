import { Component } from '@angular/core';
import { Need } from '../need';
import { User } from '../user';
import {NeedsService} from '../needs.service';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss']
})
export class HomepageComponent {
  needs: Need[] = [];
  isLoggedIn: boolean = false;
  isAdmin: boolean = false;

  constructor(private needsService: NeedsService,
              private cartService: CartService) {}


  ngOnInit(): void {
    this.getNeeds();
    localStorage.removeItem("editneed");
    localStorage.setItem("isEditingNeed", "false");
    localStorage.setItem("isCreatingNeed", "false");
    var currentUser = localStorage.getItem("currentUser");
    if (currentUser == null) {
      this.isLoggedIn = false;
    } else {
      this.isLoggedIn = true;

      var user: User = JSON.parse(currentUser);
      this.isAdmin = user.admin;
    }
  }

  getNeeds(): void {
    this.needsService.getNeeds()
      .subscribe(needs => this.needs = needs);
  }

  searchNeeds(name: string): void {
    this.needsService.searchNeeds(name)
      .subscribe(needs => this.needs = needs);
  }

  addCart(need: Need): void {
    this.needsService.addCart(need)
      .subscribe(need => need);
    this.cartService.getNeeds()
      .subscribe(needs => {
        var currentUser = localStorage.getItem("currentUser");
        if (currentUser == null) {
        } else {
          var tempUser = JSON.parse(currentUser);
          tempUser.cart = needs;
          console.log("Current User:");
          console.log(tempUser);
          localStorage.setItem("currentUser", JSON.stringify(tempUser));
        }
      });
  }

  editNeed(need: Need): void {
    localStorage.setItem("isEditingNeed", "true")
    localStorage.setItem("editneed", JSON.stringify(need));
    location.pathname = ('/edit-need');
  }

  createNeed(): void {
    localStorage.setItem("isCreatingNeed", "true");
    location.pathname = ('/edit-need');
  }

  deleteNeed(need: Need): void {
    this.needsService.deleteNeed(need)
    .subscribe(_need => {
      window.location.reload();
    });
  }
}
