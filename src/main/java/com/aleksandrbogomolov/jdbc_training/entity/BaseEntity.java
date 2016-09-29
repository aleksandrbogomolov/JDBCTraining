package com.aleksandrbogomolov.jdbc_training.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.beans.Transient;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class BaseEntity {

    private Integer id;

    @Transient
    public boolean isNew() {
        return this.id == null;
    }
}
