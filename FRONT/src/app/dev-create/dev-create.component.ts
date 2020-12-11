import { Component, OnInit } from '@angular/core';
import { DevService } from './../services/dev-service.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Developpeur } from '../models/Developpeur';
import { Router } from '@angular/router';
import { Output, EventEmitter } from '@angular/core';


@Component({
  selector: 'app-dev-create',
  templateUrl: './dev-create.component.html',
  styleUrls: ['./dev-create.component.css']
})
export class DevCreateComponent implements OnInit {


  createForm: FormGroup;

  @Output() createEvent = new EventEmitter<Developpeur>();

  constructor(public formBuilder: FormBuilder,
              private developpeursService: DevService) { }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group({
      nom: '',
      avatar: ''
    });
  }

  onSubmit(developpeurData): void {
    this.createForm.reset();
    const developpeur: Developpeur = {
      nom: developpeurData.nom,
      avatar: developpeurData.avatar
    };
    this.developpeursService.createDeveloppeur(developpeur).subscribe((developpeurResponse) => {
      this.createEvent.emit(developpeurResponse);
    });
  }

}

