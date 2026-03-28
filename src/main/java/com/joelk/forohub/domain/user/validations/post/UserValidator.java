package com.joelk.forohub.domain.user.validations.post;

import com.joelk.forohub.domain.user.DataRegistrationUser;

public interface UserValidator {
    void validate(DataRegistrationUser data);
}
