import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, UrlSegment } from '@angular/router';

@Component({
  selector: 'app-navigation-header',
  templateUrl: './navigation-header.component.html',
  styleUrls: ['./navigation-header.component.css']
})
export class NavigationHeaderComponent implements OnInit {

  public route: UrlSegment[] = [];
  
  constructor(
    private _r: Router,
    private _ar: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this._ar.url.subscribe(r => {
      this.route = r;
    });
  }

  onBack() {
    this._r.navigate([".."], {relativeTo: this._ar})
  }

}
