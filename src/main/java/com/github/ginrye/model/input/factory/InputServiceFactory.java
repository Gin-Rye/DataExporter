package com.github.ginrye.model.input.factory;

import com.github.ginrye.base.interfaces.IFactory;
import com.github.ginrye.model.input.InputService;

public interface InputServiceFactory<T extends InputService<?>> extends IFactory<T> {

}
