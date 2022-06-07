import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import WaveSurfer from 'wavesurfer.js';
import TimelinePlugin from 'wavesurfer.js/src/plugin/timeline';

@Component({
  selector: 'app-editer-projet',
  templateUrl: './editer-projet.component.html',
  styleUrls: ['./editer-projet.component.css']
})
export class EditerProjetComponent implements OnInit {

  wave: WaveSurfer|undefined;
  url = "https://ia800508.us.archive.org/15/items/LoveThemeFromTheGodfather/02LoveThemeFromTheGodfather.mp3";

  constructor( private cdr: ChangeDetectorRef) { }

  ngOnInit(): void {
  }

  generateWaveform(): void {
    Promise.resolve(null).then(() => {
      this.wave = WaveSurfer.create({
        container: '#waveform',
        waveColor: 'violet',
        progressColor: 'purple',
        plugins: [
          TimelinePlugin.create({
            container: '#wave-timeline'
          })
        ]
      });
      
      this.wave.on('ready', () => {
        alert("I'm ready");
        //this.wave.play();
      });
    });
  }

  onPreviewPressed(): void {
    if (!this.wave) {
      this.generateWaveform();
    }

    this.cdr.detectChanges();

    //Promise.resolve().then(() => this.wave.load(this.url));
  }

  onStopPressed(): void {
    //this.wave.stop();
  }
}
