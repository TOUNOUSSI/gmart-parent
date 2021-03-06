import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { PostBodyComponent } from "./post-body/post-body.component";
import { PostHeaderComponent } from "./post-header/post-header.component";
import { PostFooterComponent } from "./post-footer/post-footer.component";
import { PostWidgetComponent } from "./post-widget/post-widget.component";
import { RouterModule } from "@angular/router";
import { NewPostModalComponent } from "./new-post-modal/new-post-modal.component";
import { AngularMaterialModule } from "src/app/angular-material.module";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import {
  MatCardModule,
  MatDialogModule,
  MatSelectModule,
} from "@angular/material";
import { CommentBoxComponent, CommentModule } from "../comment";
import { ReactionComponent } from "./reaction/reaction.component";
import { OrderModule, OrderPipe } from "ngx-order-pipe";

@NgModule({
  declarations: [
    PostBodyComponent,
    PostHeaderComponent,
    PostFooterComponent,
    PostWidgetComponent,
    NewPostModalComponent,
    ReactionComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    MatDialogModule,
    MatSelectModule,
    MatCardModule,
    AngularMaterialModule,
    CommentModule,
    OrderModule,
  ],
  exports: [PostWidgetComponent, NewPostModalComponent],
  providers: [OrderPipe],
  entryComponents: [
    PostWidgetComponent,
    NewPostModalComponent,
    CommentBoxComponent,
  ],
})
export class PostModule {}
