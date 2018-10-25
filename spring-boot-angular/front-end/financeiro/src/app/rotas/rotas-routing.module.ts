import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CategoriaGridComponent } from '../categoria-grid/categoria-grid.component';
import { TemplateComponent } from '../template/template.component';
import { LancamentoGridComponent } from '../lancamento-grid/lancamento-grid.component';

const routes: Routes = [
  {
    path: '',
    component: TemplateComponent,
    pathMatch: 'full'
  },
  {
    path: '',
    component: TemplateComponent,
    children: [{
      path: 'categorias',
      component: CategoriaGridComponent
    }, 
    {
      path: 'lancamentos',
      component: LancamentoGridComponent
    }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class RotasRoutingModule { }
