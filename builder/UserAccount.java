class UserAccount {
    // Required
    private final String id;
    private final String email;

    // Optional
    private final String phoneNumber;

    public static class Builder {
        private String id;
        private String email;

        private String phoneNumber;

        public Builder id(String value) {
            this.id = value;
            return this;
        };

        public Builder email(String value) {
            this.email = value;
            return this;
        };

        public Builder phoneNumber(String value) {
            this.phoneNumber = value;
            return this;
        };

        public UserAccount build() {
            return new UserAccount(this);
        }
    }

    private UserAccount(Builder builder) {
        if (builder.id == null || builder.id.isBlank()) {
            throw new IllegalArgumentException("User ID cannot be null or blank");
        }

        if (builder.email == null || !builder.email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }

        this.id = builder.id;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
    }
}

UserAccount account = new UserAccount.Builder().id("1").email("huynhpluu@gmail.com").build();
