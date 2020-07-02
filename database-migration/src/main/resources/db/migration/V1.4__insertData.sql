INSERT into reports(id, version, description, display_name,
                    reviewed, reference_source, priority,
                    created_date, last_modified_date, is_custom_report
)
values (1, 1, 'desc 1', 'ONE', 'yes', 1, 1, '10-24-2019', '10-24-2019', false),
       (2, 2, 'desc 2', 'TWO', 'yes', 2, 2, '10-23-2019', '10-23-2019', false),
       (3, 3, 'desc 3', 'THREE', 'yes', 3, 3, '10-22-2019', '10-22-2019', false),
       (4, 4, 'desc 4', 'FOUR', 'yes', 4, 4, '10-21-2019', '10-21-2019', false),
       (5, 5, 'desc 5', 'FIVE', 'yes', 5, 5, '10-20-2019', '10-20-2019', false);


Insert into user_reports(user_id, report_id)
values(1, 1),
      (2,2),
      (3,3),
      (4,4),
      (5,5);

Insert into users(id, version, user_id, dn, last_login_date)
values(1, 1, 'stan', 'stan1', '10-23-2019'),
      (2, 2, 'paul', 'M', '10-22-2019'),
      (3, 3, 'ringo', 'star', '10-21-2019');

