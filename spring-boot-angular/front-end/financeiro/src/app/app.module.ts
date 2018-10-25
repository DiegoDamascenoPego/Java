import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { TemplateComponent } from './template/template.component';
import { CategoriaGridComponent } from './categoria-grid/categoria-grid.component';
import { RotasRoutingModule } from './rotas/rotas-routing.module';
import { CategoriaFormComponent } from './categoria-form/categoria-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LancamentoGridComponent } from './lancamento-grid/lancamento-grid.component';
import { LancamentoFormComponent } from './lancamento-form/lancamento-form.component';
import { AutoCompleteModule } from 'primeng/autocomplete';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CalendarModule } from 'primeng/calendar';
import { CustomFormsModule } from 'ng2-validation';
import { ToastModule } from 'primeng/toast';
import { MessageService } from 'primeng/api';


@NgModule({
  declarations: [
    AppComponent,
    TemplateComponent,
    CategoriaGridComponent,
    CategoriaFormComponent,
    LancamentoGridComponent,
    LancamentoFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RotasRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    AutoCompleteModule,
    BrowserAnimationsModule,
    CalendarModule,
    CustomFormsModule,
    ToastModule
  ],
  providers: [MessageService],
  bootstrap: [AppComponent],
})
export class AppModule { }
