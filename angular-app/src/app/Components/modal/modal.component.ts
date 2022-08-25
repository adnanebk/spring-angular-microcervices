import {Component, Input, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {NgbModal, NgbModalRef} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent implements OnInit {

  @ViewChild('modal') private modalContent: TemplateRef<ModalComponent>;
  private modalRef: NgbModalRef;

  constructor(private modalService: NgbModal) {
  }

  ngOnInit(): void {
  }

  open(content: string) {
    this.modalRef = this.modalService.open(content);
    this.modalRef.result.then();
  }

  close() {
    this.modalRef.close();
  }

  dismiss() {
    this.modalRef.dismiss();
  }
}
