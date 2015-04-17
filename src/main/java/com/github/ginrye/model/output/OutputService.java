package com.github.ginrye.model.output;

import com.github.ginrye.base.exception.BusinessException;
import com.github.ginrye.base.resultstore.ResultStore;

public interface OutputService {
	void output(ResultStore store) throws BusinessException;
}
