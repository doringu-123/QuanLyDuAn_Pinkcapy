CREATE TABLE jobs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    category VARCHAR(100) NOT NULL,
    status VARCHAR(50) NOT NULL,
    location VARCHAR(100) NOT NULL,
    pdate DATE NOT NULL
);

CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    qualification VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

INSERT INTO user (name, email, password, qualification, role)
VALUES 
    ('Nguyen Hai Thien', 'nguyenhaithien2k5@gmail.com', '123', 'Bachelor''s in Computer Science', 'user'),
    ('Admin', 'admin@gmail.com', '123', 'Master''s in IT', 'admin');

INSERT INTO jobs (title, description, category, status, location, pdate)
VALUES 
    ('Software Engineer', 'Develop and maintain web applications using Java and Spring.', 'Engineering', 'Active', 'New York', '2025-05-01'),
    ('Marketing Manager', 'Lead marketing campaigns and strategy development.', 'Marketing', 'Active', 'Los Angeles', '2025-05-05'),
    ('Sales Executive', 'Drive sales and manage client relationships.', 'Sales', 'Inactive', 'Chicago', '2025-05-10'),
    ('Data Analyst', 'Analyze data to provide business insights.', 'Analytics', 'Active', 'San Francisco', '2025-05-15'),
    ('Project Manager', 'Oversee project execution and team coordination.', 'Management', 'Active', 'Seattle', '2025-05-20'),
    ('UX Designer', 'Design user-friendly interfaces for web and mobile apps.', 'Design', 'Active', 'Austin', '2025-05-25'),
    ('DevOps Engineer', 'Manage CI/CD pipelines and cloud infrastructure.', 'Engineering', 'Active', 'Boston', '2025-05-28'),
    ('HR Specialist', 'Handle recruitment and employee relations.', 'Human Resources', 'Active', 'Miami', '2025-05-30');