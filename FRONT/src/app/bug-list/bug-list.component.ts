import { BugsService } from './../services/bug-service.service';
import { Component, OnInit } from '@angular/core';
import { Bug } from '../models/Bug';
import { delay } from 'rxjs/operators';

@Component({
  selector: 'app-bug-list',
  templateUrl: './bug-list.component.html',
  styleUrls: ['./bug-list.component.css']
})
export class BugListComponent implements OnInit {


  public bugs: Bug[];

  public showSpinner: boolean;

  constructor(private bugsServices: BugsService) { }

  ngOnInit(): void {
    this.showSpinner = true;
    this.bugsServices.getAllBugs()
    .pipe(delay(2000))
    .subscribe((developpeursResponse => {
      this.bugs = developpeursResponse;
      this.showSpinner = false;
    }));
  }

  /* Callback of child component */
  addDeveloppeur(newDeveloppeur: Bug): void {
    this.bugs.push(newDeveloppeur);
  }

}
