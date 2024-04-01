import { Component } from '@angular/core';
import { Need } from '../need';
import {CartService} from '../cart.service';
import {User} from '../user';

@Component({
  selector: 'app-cartpage',
  templateUrl: './cartpage.component.html',
  styleUrls: ['./cartpage.component.scss']
})
export class CartpageComponent {
  needs: Need[] = [];
  currentUser: User = {} as User;

  constructor(private cartService: CartService) {}

  ngOnInit(): void {
    this.getNeeds();
    var currentUser = localStorage.getItem("currentUser");
    if (currentUser == null) {
    } else {
      this.currentUser = JSON.parse(currentUser);
      this.currentUser.cart = this.needs;
      console.log("Current User:");
      console.log(this.currentUser);
      localStorage.setItem("currentUser", JSON.stringify(this.currentUser));
    }
  }

  getNeeds(): void {
    this.cartService.getNeeds()
      .subscribe(needs => {
        this.needs = needs
        var currentUser = localStorage.getItem("currentUser");
        if (currentUser == null) {
        } else {
          this.currentUser = JSON.parse(currentUser);
          this.currentUser.cart = this.needs;
          console.log("Current User:");
          console.log(this.currentUser);
          localStorage.setItem("currentUser", JSON.stringify(this.currentUser));
        }
      });
  }

  removeItem(id: number): void {
    this.cartService.removeItem(id)
      .subscribe(_need => {
        window.location.reload();
    });

  }

  submitCart(): void {
    this.cartService.submitCart()
      .subscribe(() => {
        window.location.reload();
      });
  }
}
