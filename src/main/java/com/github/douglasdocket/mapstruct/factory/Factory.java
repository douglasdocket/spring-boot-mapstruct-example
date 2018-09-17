package com.github.douglasdocket.mapstruct.factory;

public interface Factory<I, V, D> {

	D fabricateFromInputObject(I i);

	D fabricateFromViewObject(V v);

}
