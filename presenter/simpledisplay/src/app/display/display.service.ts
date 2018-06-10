import { Injectable } from '@angular/core';

import { Subject } from 'rxjs/Subject';
import { Observable } from 'rxjs/Observable';
import * as io from 'socket.io-client';

@Injectable()
export class DisplayService {

    private url = 'http://localhost:5000';
    private socket;

    sendMessage(message) {
        this.socket.emit('add-message', message);
    }

    getInstructions() {
        let observable = new Observable(observer => {
            this.socket.on('message', (data) => {
                observer.next(data);
            });
            return () => {
                this.socket.disconnect();
            };
        });
        return observable;
    }

    getUpdates() {
        let observable2 = new Observable(observer => {
            this.socket.on('update', (data) => {
                observer.next(data);
            });
            return () => {
                this.socket.disconnect();
            };
        });
        return observable2;
    }

  constructor() {
      this.socket = io(this.url);
      }

}
