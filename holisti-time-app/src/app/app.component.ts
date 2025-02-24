import { ChangeDetectionStrategy, Component } from '@angular/core';
import { LoaderService } from "./core/services/LoaderService";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class AppComponent {
  title = 'holisti-time-app';

  constructor(
    public readonly loaderService: LoaderService
  ) {
  }
}
