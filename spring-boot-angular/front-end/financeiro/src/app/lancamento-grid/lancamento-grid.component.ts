import { Component, OnInit } from '@angular/core';
import { Lancamento } from '../model/lancamento';
import { LancamentoService } from '../service/lancamento.service';

declare var $: any;

@Component({
  selector: 'app-lancamento-grid',
  templateUrl: './lancamento-grid.component.html',
  styleUrls: ['./lancamento-grid.component.css']
})
export class LancamentoGridComponent implements OnInit {

  lancamentos: Array<Lancamento>;
  lancamentoSelecionado: Lancamento;

  constructor(private service: LancamentoService) { }

  ngOnInit() {
    this.service.listar().subscribe(
      (Response) => {
        this.lancamentos = Response;
      },
      (erro) => {
        console.log('erro ao filtrar');

      }
    );
  }

  novo() {
    this.lancamentoSelecionado = new Lancamento();
    $('#modalNovo').modal('show');
  }

  onSalvarLancamento(event) {
    $('#modalNovo').modal('hide');
    this.ngOnInit();
  }

  onRemoverLancamento(event) {
    $('#modalNovo').modal('hide');
    this.ngOnInit();
  }
  editar(obj: Lancamento) {
    this.lancamentoSelecionado = obj;
    $('#modalNovo').modal('show');
  }

}
