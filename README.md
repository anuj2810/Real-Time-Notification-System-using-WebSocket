# 🚀 Real-Time Notification System

**Enterprise-grade notification engine built with Spring Boot, WebSocket, and MongoDB.**

This project delivers a robust, scalable backend solution for real-time messaging, simulating high-concurrency systems found in modern social platforms (e.g., YouTube subscriber notifications). It leverages the power of WebSocket for instant, two-way communication between server and client.

## 🌟 Key Features

*   **Real-Time Delivery**: Instant push notifications via WebSocket (STOMP protocol).
*   **Modern UI**: Glassmorphism-styled frontend with dark mode for a premium user experience.
*   **Scalable Architecture**: Built on Spring Boot 3.5.6 for high performance and reliability.
*   **Persistent Storage**: MongoDB integration for reliable notification storage and history.
*   **Dynamic Channel Management**: Support for subscribing to specific notification channels.
*   **Production Ready**: Clean, modular codebase following industry best practices.

## 🛠 Tech Stack

*   **Backend**: Spring Boot 3.x, Java 21
*   **Database**: MongoDB
*   **Frontend**: HTML5, CSS3, JavaScript (Vanilla)
*   **Communication**: WebSocket (STOMP), SockJS
*   **Build Tool**: Maven

## 📦 Installation & Setup

### Prerequisites
*   Java 21 or higher
*   Maven 3.8+
*   MongoDB (running on `localhost:27017`)

### Steps

1.  **Clone the Repository**
    ```bash
    git clone <your-repo-url>
    cd realtime-notifications
    ```

2.  **Configure Database**
    Ensure your MongoDB instance is running. The application connects to `mongodb://localhost:27017/test` by default. You can modify this in `src/main/resources/application.properties`.

3.  **Build the Project**
    ```bash
    mvn clean install
    ```

4.  **Run the Application**
    ```bash
    mvn spring-boot:run
    ```
    The server will start on `http://localhost:8080`.

## 🧪 Usage & Demo

### 1. Frontend
1.  Open `http://localhost:8080` in your browser.
2.  Click **"Use Demo ID"** to generate a random user ID.
3.  Click **"Connect"** to establish the WebSocket connection.
4.  The status indicator will turn green.

### 2. Triggering Notifications (API)
Since there is no "Admin Panel" UI yet, use your **Terminal** or **Browser Console** to trigger events.

#### A. Subscribe a User to a Channel
*Replace `100` with the User ID shown on your screen.*

**PowerShell:**
```powershell
Invoke-RestMethod -Method Post -Uri "http://localhost:8080/api/subscriptions/subscribe" `
-ContentType "application/json" `
-Body '{"userId": 100, "channelId": 1}'
```

**JavaScript (Browser Console):**
```javascript
fetch('/api/subscriptions/subscribe', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ userId: 100, channelId: 1 })
}).then(res => res.text()).then(console.log);
```

#### B. Send a Notification
*This sends a message to all users subscribed to Channel 1.*

**PowerShell:**
```powershell
Invoke-RestMethod -Method Post -Uri "http://localhost:8080/api/notifications/publish" `
-ContentType "application/json" `
-Body '{"channelId": 1, "videoId": "v101", "videoTitle": "Live Stream Started!"}'
```

**JavaScript (Browser Console):**
```javascript
fetch('/api/notifications/publish', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({
        channelId: 1,
        videoId: "v101",
        videoTitle: "Live Stream Started!"
    })
}).then(res => res.text()).then(console.log);
```

## 📂 Project Structure

```
src
├── main
│   ├── java/com/realtime/notifications
│   │   ├── config       # WebSocket configuration
│   │   ├── controller   # REST & WebSocket controllers
│   │   ├── dto          # Data Transfer Objects
│   │   ├── model        # MongoDB documents
│   │   ├── repo         # Repository interfaces
│   │   └── service      # Business logic
│   └── resources
│       ├── static       # Frontend assets
│       │   ├── css      # Modern styling
│       │   ├── js       # Application logic
│       │   └── index.html
│       └── application.properties
```

## 🔮 Future Improvements

*   [ ] OAuth2 Authentication & Security
*   [ ] Redis for session management and horizontal scaling
*   [ ] Enhanced frontend UI with React/Next.js
*   [ ] Docker & Kubernetes support

## 👨‍💻 Author

**Anuj Arya**
*Senior Software Architect*

Building scalable, high-performance systems for the modern web.

---
© 2026 Real-Time Notification System. All rights reserved.
