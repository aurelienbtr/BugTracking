import { DevService } from './../services/dev-service.service';
import { Component, OnInit } from '@angular/core';
import { Developpeur } from '../models/Developpeur';
import { delay } from 'rxjs/operators';

@Component({
  selector: 'app-dev-list',
  templateUrl: './dev-list.component.html',
  styleUrls: ['./dev-list.component.css']
})
export class DevListComponent implements OnInit {


  public developpeurs: Developpeur[];

  public showSpinner: boolean;

  constructor(private developpeursServices: DevService) { }

  ngOnInit(): void {
    this.showSpinner = true;
    this.developpeursServices.getAllDeveloppeur()
    .pipe(delay(2000))
    .subscribe((developpeursResponse => {
      this.developpeurs = developpeursResponse;
      this.showSpinner = false;
    }));
  }

  /* Callback of child component */
  addDeveloppeur(newDeveloppeur: Developpeur): void {
    this.developpeurs.push(newDeveloppeur);
  }

}
