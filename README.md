# Spring Boot Challenge Project

Bu projede, Spring Boot ile company ve employee tablolarındaki verileri yönetmek için temel CRUD işlemlerini gerçekleştiren bir Restful API oluşturuldu.

## İçindekiler
1. [Kullanılan Teknolojiler](#kullanılan-teknolojiler)
2. [Kurulum ve Yapılandırma](#kurulum-ve-yapılandırma)
3. [Veritabanına Genel Bakış](#veritabanına-genel-bakış)
4. [API Endpoints](#api-endpoints)

## Kullanılan Teknolojiler

- Java 17
- Spring Boot 3.1.4
- Maven 3.8.5
- PostgreSQL 14
- Spring Data JPA
- Lombok
- Validation


## Kurulum ve Yapılandırma

#### 1. Projeyi Klonlayın
```shell
git clone https://github.com/hasancolk/challenge-project.git
```
#### 2. Veritabanı ayarlarını düzenleyin
src/main/resources/application.properties dosyasında aşağıdaki ayarlamaları kendi veritabanınıza göre yapılandırın.
```shell
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
```
#### 3. Proje Dizinine Gidin
```shell
cd challenge-project
```
#### 4. Projeyi çalıştırın
```shell
mvn spring-boot:run
```


## Veritabanına Genel Bakış

### Company Tablosu

| Column    | Type   | Description             |
|-----------|--------|-------------------------|
| id        | Long   | Primary Key             |
| name      | String | Şirket Adı              |
| industry  | String | Şirketin Faaliyet Alanı |

### Employee Tablosu

| Column      | Type   | Description                   |
|-------------|--------|-------------------------------|
| id          | Long   | Primary Key                   |
| name        | String | Çalışanın Adı                 |
| surname     | String | Çalışanın Soyadı              |
| title       | String | Çalışanın Unvanı              |
| department  | String | Çalışanın Departmanı          |
| company_id  | Long   | Foreign Key (Company Tablosu) |

`company_id` alanı, Employee tablosunu Company tablosu ile ilişkilendirir. Bu alandaki değerler, Company tablosundaki `id` sütununa referanstır.

## API Endpoints

### Company API Endpoints
- `POST /api/company/createCompany`: Yeni bir şirket oluşturur. name ve industry değeri zorunlu alandır.
```json
Request Body:
{
  "name": "Enoca",
  "industry": "IT"
}
```
```json
Response Body:
{
  "data": {
    "createdCompany": {
      "id": 1,
      "name": "Enoca",
      "industry": "IT"
    }
  },
  "errDesc": null,
  "success": true
}
```


- `PUT /api/company/updateCompany`: Parametre olarak verilen companyId değerindeki şirketi günceller. id değeri zorunlu alandır.
```json
Request Body:
{
  "id": 1
  "name": "Enoca",
  "industry": "IT"
}
```
```json
Response Body:
{
  "data": {
    "updatedCompany": {
      "id": 1,
      "name": "Enoca",
      "industry": "IT"
    }
  },
  "errDesc": null,
  "success": true
}
```

- `DELETE /api/company/deleteCompany/{companyId}`: URL'deki {companyId} değerine sahip şirketi siler.
```json
Response Body:
{
  "data": {
    "message": "Company with ID: 1 has been successfully deleted."
  },
  "errDesc": null,
  "success": true
}
```

- `GET /api/company/getCompanyById/{companyId}`: URL'deki {companyId} değerine sahip şirketin bilgilerini getirir.
```json
Response Body:
{
  "data": {
    "company": {
      "id": 1,
      "name": "Enoca",
      "industry": "IT"
    }
  },
  "errDesc": null,
  "success": true
}
```

- `GET /api/company/getAllCompanies`: Veritabanında kayıtlı tüm şirketlerin bilgilerini getirir.
```json
Response Body:
{
  "data": {
    "companies": [
      {
        "id": 1,
        "name": "Enoca",
        "industry": "IT"
      },
      {
        "id": 2,
        "name": "TUSAŞ",
        "industry": "Defense Industry"
      },
      {
        "id": 3,
        "name": "Ziraat Bankası",
        "industry": "Banking"
      }
    ]
  },
  "errDesc": null,
  "success": true
}
```



### Employee API Endpoints
- `POST /api/employee/createEmployee`: Yeni bir çalışan oluşturur. name, surname, title, department, companyId alanları zorunludur.
```json
Request Body:
{
  "name": "Ali",
  "surname": "Yıldırım",
  "title": "Software Engineer",
  "department": "Product Development",
  "companyId": 1
}
```
```json
Response Body:
{
  "data": {
    "createdEmployee": {
      "id": 1,
      "name": "Ali",
      "surname": "Yıldırım",
      "title": "Software Engineer",
      "department": "Product Development",
      "companyName": "Enoca"
    }
  },
  "errDesc": null,
  "success": true
}
```


- `PUT /api/employee/updateEmployee`: Parametre olarak verilen employeeId değerindeki çalışanı günceller. id değeri zorunlu alandır.
```json
Request Body:
{
   "id": 1,
     "name": "Ali",
   "surname": "Yıldırım",
   "title": "Software Engineer",
   "department": "Product Development",
   "companyName": "Enoca"
}
```
```json
Response Body:
{
  "data": {
    "updatedEmployee": {
      "id": 1,
      "name": "Ali",
      "surname": "Yıldırım",
      "title": "Software Engineer",
      "department": "Product Development",
      "companyName": "Enoca"
    }
  },
  "errDesc": null,
  "success": true
}
```

- `DELETE /api/employee/deleteEmployee/{employeeId}`: URL'deki {employeeId} değerine sahip çalışanı siler.
```json
Response Body:
{
  "data": {
    "message": "Employee with ID: 1 has been successfully deleted."
  },
  "errDesc": null,
  "success": true
}
```

- `GET /api/employee/getEmployeeById/{employeeId}`: URL'deki {employeeId} değerine sahip çalışanı getirir.
```json
Response Body:
{
  "data": {
    "employee": {
      "id": 1,
      "name": "Ali",
      "surname": "Yıldırım",
      "title": "Software Engineer",
      "department": "Product Development",
      "companyName": "Enoca"
    }
  },
  "errDesc": null,
  "success": true
}
```

- `GET /api/employee/getEmployeesByCompanyId/{companyId}`: URL'deki {companyId} değerine sahip şirkete ait tüm çalışan bilgilerini getirir.
```json
Response Body:
{
  "data": {
    "employees": [
      {
        "id": 1,
        "name": "Ali",
        "surname": "Yıldırım",
        "title": "Software Engineer",
        "department": "Product Development",
        "companyName": "Enoca"
      },
      {
        "id": 1,
        "name": "Burak",
        "surname": "Yılmaz",
        "title": "Software Engineer",
        "department": "Payment Systems",
        "companyName": "Enoca"
      }
    ]
  },
  "errDesc": null,
  "success": true
}
```

- `GET /api/employee/getAllEmployees`: Veritabanında kayıtlı tüm çalışan bilgilerini getirir.
```json
Response Body:
{
  "data": {
    "employees": [
      {
        "id": 1,
        "name": "Ali",
        "surname": "Yıldırım",
        "title": "Software Engineer",
        "department": "Product Development",
        "companyName": "Enoca"
      },
      {
        "id": 1,
        "name": "Burak",
        "surname": "Yılmaz",
        "title": "Software Engineer",
        "department": "Payment Systems",
        "companyName": "Enoca"
      },
      {
        "id": 1,
        "name": "Mehmet",
        "surname": "Kaya",
        "title": "Team Lead",
        "department": "Product Development",
        "companyName": "TUSAŞ"
      }
    ]
  },
  "errDesc": null,
  "success": true
}
```
