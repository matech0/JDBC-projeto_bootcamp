ALTER TABLE accesses
    ADD COlUMN read_data boolean default false,
    ADD COlUMN delete_data boolean default false,
    ADD COlUMN create_data boolean default false,
    ADD COlUMN update_data boolean default false;