import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerComponent } from './customer.component';
import { RoomsComponent } from './components/rooms/rooms.component';
import { ViewBookingComponent } from './components/view-booking/view-booking.component';


const routes: Routes = [
  { path: '', component: CustomerComponent },
  { path: 'room', component: RoomsComponent },
  { path: 'bookings', component: ViewBookingComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule { }
