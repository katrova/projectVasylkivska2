package com.vsemvs.projectVasylkivska.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*
  @author   Kateryna Vasylkivska
  @project   projectVasylkivska
  @class  Order
  @version  1.0.0
  @since 7/30/2021 - 15.12
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pair<T, K> {
    private T key;
    private K value;
}
