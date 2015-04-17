package com.github.ginrye.model.input;

import com.github.ginrye.base.exception.BusinessException;
import com.github.ginrye.base.resultstore.ResultStore;
import com.github.ginrye.model.input.query.Query;

public interface InputService<T> {
	ResultStore input(Query<T> query) throws BusinessException;
}
