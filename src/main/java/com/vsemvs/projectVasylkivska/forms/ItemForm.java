package com.vsemvs.projectVasylkivska.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
  @author   Kateryna Vasylkivska
  @project   projectVasylkivska
  @class  ItemForm
  @version  1.0.0 
  @since 7/22/2021 - 10.42
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemForm {
    private String name;
    private String description;
}
