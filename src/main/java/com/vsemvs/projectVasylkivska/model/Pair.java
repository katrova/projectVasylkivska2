package com.vsemvs.projectVasylkivska.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pair<T, K> {
    private T key;
    private K value;
}
