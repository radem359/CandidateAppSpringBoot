insert into candidate(name, surname, unique_identification_number, year_of_birth, email, telephone_number, note, is_hired, last_change)
values ("Radosav", "Mijovic", "0112995810096", 1995, "radem@gmail.com", "0652086053", "", true, "08.09.2019")

insert into concourse(job, job_code)
values ("Junior Software developer", "SD-T4")

insert into values concourse_candidates(concourses_id, candidates_id)
values (1, 1)