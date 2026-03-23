package com.joelk.forohub.domain.user;

public record DataDetailUser(
        Long id,
        String name,
        String email
) {
    public DataDetailUser(User user) {
        this(user.getId(), user.getName(), user.getEmail());
    }
}
