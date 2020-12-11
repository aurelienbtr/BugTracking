import { DeveloppeurService } from './../services/dev-service.service';
import { Component, OnInit } from '@angular/core';
import { Developpeur } from '../models/Developpeur';
import { delay } from 'rxjs/operators';

@Component({
  selector: 'app-dev-list',
  templateUrl: './dev-list.component.html',
  styleUrls: ['./dev-list.component.css']
})
export class StudentListCDevListComponentomponent implements OnInit {


  public developpeurs: Developpeur[];

  public showSpinner: boolean;

  constructor(private developpeursServices: DeveloppeurService) { }

  ngOnInit(): void {
    this.showSpinner = true;
    this.developpeursServices.getStudentsList()
    .pipe(delay(2000))
    .subscribe((studentsResponse => {
      this.developpeurs = developpeursResponse;
      this.showSpinner = false;
    }));
  }

  deleteStudent(id: number): void {
    this.developpeursServices.deleteStudent(id).subscribe((deleteResponse) => {
      this.developpeurs = this.developpeurs.filter(s => s.id !== id);
    }, (error) => {
      // TODO
    });
  }
  /* Callback of child component */
  addStudent(newDeveloppeur: Developpeur): void {
    this.developpeurs.push(newDeveloppeur);
  }

}
