import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BugListComponent } from './bug-list/bug-list.component';
import { BugCreateComponent } from './bug-create/bug-create.component';
import { DevCreateComponent } from './dev-create/dev-create.component';
import { DevListComponent } from './dev-list/dev-list.component';
import { BugFindComponent } from './bug-find/bug-find.component';
import { BugDetailComponent } from './bug-detail/bug-detail.component';
import { DevDetailComponent } from './dev-detail/dev-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    BugListComponent,
    BugCreateComponent,
    DevCreateComponent,
    DevListComponent,
    BugFindComponent,
    BugDetailComponent,
    DevDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

