import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Categoria } from '../model/categoria';
import { Lancamento } from '../model/lancamento';
import { LancamentoService } from '../service/lancamento.service';
import { CategoriaService } from '../service/categoria.service';
import { CustomFormsModule, CustomValidators } from 'ng2-validation';

@Component({
  selector: 'app-lancamento-form',
  templateUrl: './lancamento-form.component.html',
  styleUrls: ['./lancamento-form.component.css']
})
export class LancamentoFormComponent implements OnInit, OnChanges {

  @Input() lancamento: Lancamento = new Lancamento();

  // tslint:disable-next-line:no-output-on-prefix
  @Output() onSalvar: EventEmitter<any> = new EventEmitter();

  // tslint:disable-next-line:no-output-on-prefix
  @Output() onRemover: EventEmitter<any> = new EventEmitter();


  form: FormGroup;
  listaCategoria: Categoria[];


  constructor(private fb: FormBuilder, private service: LancamentoService, private cateoriaService: CategoriaService) {
    this.form = fb.group({
      id: [],
      nome: ['', Validators.required],
      tipo: ['DESPESA'],
      data: ['', Validators.required],
      valor: ['', [Validators.required, CustomValidators.number]],
      categoria: ['']
    });
  }

  ngOnInit() {


  }

  ngOnChanges(changes: SimpleChanges) {
    console.log('ngOnChanges', changes);
    this.form.reset();
    if (changes.lancamento && this.lancamento) {
      if (!this.lancamento.data) {
        this.lancamento.data = new Date();
      }
      this.form.patchValue(this.lancamento);
    }
  }

  salvar() {
    this.lancamento = this.form.value;

    this.service.salvar(this.lancamento).subscribe(() => {
      console.log('Deu Certo');
      this.onSalvar.emit();
    },
      (erro) => {
        console.log('Não Deu certo');
      });
  }

  remover() {
    this.lancamento = this.form.value;
    this.service.remover(this.lancamento.id).subscribe(() => {
      console.log('Deu Certo');
      this.onRemover.emit();
    },
      (erro) => {
        console.log('Não Deu certo', erro);
      });
  }

  buscarCategoria(event) {
    this.cateoriaService.listarPorNome(event.query).subscribe(
      (Response) => {
        this.listaCategoria = Response;
      },
      (erro) => {
        console.log('Falha ao listar categoria');
      }
    );
  }



}
