import { Component } from 'angular2/core';
import { bootstrap } from 'angular2/platform/browser';

/** Nested Component */ 
import { DisplayComponent } from 'workstation/display.component';
import { DisplayService } from 'workstation/display.service';

@Component({
  selector: 'my-app',
  directives: [DisplayComponent],
  styles: [`
  h1 {
    color:#545454;
    background:#02A8F4;
    padding:15px;
    box-shadow:2px 2px 2px 0 rgba(0, 0, 0, 0.3);
  }
  `],
  template: `
  <div>
  <h1>Hello from the {{componentName}}.</h1>
  <my-friends></my-friends>
  </div>
  `
})
export class WorkstationComponent {
  componentName: 'WorkstationComponent'
}
bootstrap(WorkstationComponent)

