package com.github.douglasdocket.mapstruct.factory;

public interface Factory<InputObject, ViewObject, D> {

	D fabricateFromInputObject(InputObject inputObject);

	D fabricateFromViewObject(ViewObject viewObject);

}
