# 📇 Smart Contact Manager

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-green?style=for-the-badge) ![Spring Security](https://img.shields.io/badge/Spring%20Security-6.0-blue?style=for-the-badge) ![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge) ![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=for-the-badge)

🚀 **Smart Contact Manager** is a powerful and secure contact management system built using **Spring Boot 3** and **Spring Security 6**, designed for seamless organization and retrieval of contacts.

---

## 🌟 Features ✨
✅ User authentication & authorization (Login/Signup) 🔑  
✅ Role-based access (Admin/User) 👤  
✅ Add, update, and delete contacts 📇  
✅ Secure password handling with BCrypt 🔐  
✅ Responsive UI with Bootstrap 🎨  
✅ RESTful API support 🌍  

---

## 🛠️ Tech Stack 🚀
- **Backend:** Spring Boot 3, Spring Security 6, JPA, Hibernate
- **Database:** MySQL
- **Frontend:** HTML, CSS, Bootstrap, JavaScript
- **Tools:** IntelliJ IDEA / Eclipse, Postman, Git

---

## 🚀 Installation Guide ⚡

### **Prerequisites** 📌
Ensure you have the following installed:
- ☕ Java (JDK 17+)
- 🐬 MySQL
- ⚙️ Maven
- 🔗 Git

### **Clone the Repository** 📂
```sh
git clone https://github.com/your-username/smart-contact-manager.git
cd smart-contact-manager
```

### **Set Up MySQL Database** 🛢️
1. Open MySQL and create a database:
   ```sql
   CREATE DATABASE smart_contact_manager;
   ```
2. Update `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/smart_contact_manager
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   ```

### **Build and Run the Project** ▶️
```sh
mvn clean install
mvn spring-boot:run
```
Your app should now be running on **`http://localhost:8080`** 🎉

---

## 📸 Screenshots 🖼️
(Add screenshots here if available)

---

## 🔥 API Endpoints ⚡
| 🛠️ Method | 🌍 Endpoint | 📜 Description |
|-----------|-----------|---------------|
| `POST` | `/api/auth/signup` | Register a new user |
| `POST` | `/api/auth/login` | Authenticate user |
| `GET` | `/api/contacts` | Get all contacts |
| `POST` | `/api/contacts` | Add new contact |
| `PUT` | `/api/contacts/{id}` | Update contact |
| `DELETE` | `/api/contacts/{id}` | Delete contact |

---

## 🤝 Contributing 💡
Contributions are welcome! Follow these steps:
1. 🔀 Fork the repository.
2. 🌱 Create a feature branch (`git checkout -b feature-name`).
3. 💾 Commit your changes (`git commit -m 'Added new feature'`).
4. 🚀 Push to the branch (`git push origin feature-name`).
5. 🔥 Open a Pull Request.

---

## 💬 Need Help? ❓
If you have any questions, feel free to open an issue or reach out!

📧 **Email:** thorattejas809@gmail.com  
🔗 **GitHub:** [tejasthorat45](https://github.com/tejasthorat45)

---

**✨ Don't forget to star the repo if you found it useful! ⭐**
