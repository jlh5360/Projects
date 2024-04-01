import { Component } from '@angular/core';
import { Elderly } from '../elderly';
import {AdoptService} from '../adopt.service';

@Component({
  selector: 'app-adoptpage',
  templateUrl: './adoptpage.component.html',
  styleUrls: ['./adoptpage.component.scss']
})
export class AdoptpageComponent {
  elderlies: Elderly[] = [];
  // isLoggedIn: boolean = false;
  isAdmin: boolean = false;
  
  //Initialize with default values
  newElderly: Elderly = {
    id: 0,
    name: "",
    age: 0,
    gender: "",
    "level of up keep": "",
    "number of children": 0,
    description: "",
    isAdopted: false,
    isUpdated: false
  };

  updateFormVisible: boolean = false;
  updatedElderly: Elderly = {
    id: 0,
    name: "",
    age: 0,
    gender: "",
    "level of up keep": "",
    "number of children": 0,
    description: "",
    isAdopted: false,
    isUpdated: false
  };

  constructor(private adoptService: AdoptService) {}

  ngOnInit(): void {
    this.getElderlies();

    // Check user's admin status
    var currentUser = localStorage.getItem("currentUser");
    if (currentUser != null) {
      var user: any = JSON.parse(currentUser);
      this.isAdmin = user.admin;
    }
  }

  getElderlies(): void {
    this.adoptService.getElderlies()
      .subscribe(
        elderlies => this.elderlies = elderlies,
        error => console.error("Error fetching elderlies:", error)
      );
  }

  addElderly(): void {
    // Assuming there is a validation check for the new elderly data
    if (this.validateElderlyData()) {
      this.adoptService.addElderly(this.newElderly)
        .subscribe(addedElderly => {
          // Assuming you want to update the UI after adding
          this.elderlies.push(addedElderly);
          
          //Reset to default values
          this.newElderly = {
            id: 0,
            name: "",
            age: 0,
            gender: "",
            "level of up keep": "",
            "number of children": 0,
            description: "",
            isAdopted: false,
            isUpdated: false
          };

          // // Add the newly added elderly to the local list
          // this.elderlies.push(addedElderly);

          console.log("Elderly added:", addedElderly);
        },
        error => console.error("Error adding elderly:", error)
      );
    }
    else {
      // Handle validation error
      console.error('Invalid elderly data');
    }

    window.location.reload();
  }

  showUpdateForm(elderly: Elderly): void {
    // Display the update form and populate it with the elderly's information
    this.updateFormVisible = true;
    this.updatedElderly = { ...elderly }; // Copy the elderly object to avoid two-way binding issues
  }

  saveUpdatedElderly(): void {
    // Call the service to save the updated elderly information
    this.adoptService.updateElderly(this.updatedElderly)
      .subscribe(updatedElderly => {
        // Handle the updated elderly (e.g., update UI)
        console.log('Elderly updated:', updatedElderly);
        // You may want to update the UI or reset the form
        this.updateFormVisible = false;
      });
    
    window.location.reload();
  }

  // Add any additional validation logic based on your requirements
  private validateElderlyData(): boolean {
    return (
      (typeof this.newElderly.name === "string") &&
      (this.newElderly.age > 0) &&
      (typeof this.newElderly.gender === "string") &&
      (typeof this.newElderly['level of up keep'] === "string") &&
      (typeof this.newElderly['number of children'] === "number") &&
      (typeof this.newElderly.description === "string" || this.newElderly.description == null)
    );
  }

  adoptElderly(elderly: Elderly): void {
    if (this.isAdmin === false && !elderly.isAdopted) {
      // Mark the elderly as adopted
      elderly.isAdopted = true;

      // Update the UI
      // You may want to refresh the entire elderlies list or adopt only a specific one
      // For simplicity, refreshing the entire list here
      this.elderlies = [...this.elderlies];
    }
  }

  deleteElderly(id: number): void {
    this.adoptService.removeElderly(id)
      .subscribe(
        () => {
          // Assuming you want to update the UI after deleting
          this.elderlies = this.elderlies.filter(elderly => elderly.id !== id);
          console.log('Elderly deleted:', id);
        },
        error => console.error('Error deleting elderly:', error)
      );
  
    window.location.reload(); // Note: Reloading the entire page may not be necessary
  }
}