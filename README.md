# Fake Store App

![Kotlin](https://img.shields.io/badge/Kotlin-1.9.0%2B--7952FF?style=flat-square&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-1EDA8B?style=flat-square&logo=android&logoColor=white)
![Architecture](https://img.shields.io/badge/Architecture-MVVM%20%2B%20Clean-69B4F0?style=flat-square)

An Android e-commerce app built with Jetpack Compose, MVVM, and Retrofit. Consumes the [Fake Store API](https://fakestoreapi.com/) to display products, categories, and product details across 6+ Material Design 3 screens.

---

## Screenshots

> Screenshots coming soon. Run the app locally to see it in action.

---

## Features

- Product listing with category filtering
- Product detail screen with full descriptions and pricing
- Cart management with item quantity control
- User authentication flow (login / register)
- 6+ screens with Material Design 3 theming
- ~80%+ ViewModel test coverage with JUnit

---

## Tech Stack

| Category | Technology |
|----------|------------|
| Language | Kotlin |
| UI | Jetpack Compose + Material Design 3 |
| Architecture | MVVM + Clean Architecture |
| Networking | Retrofit + OkHttp |
| Concurrency | Coroutines + Flow |
| Testing | JUnit + MockK |

---

## Architecture

```text
com.example.fakestore
├── core/
│   ├── network/         # Retrofit client, interceptors
│   └── utils/           # Extensions, formatters
├── data/
│   ├── remote/          # API service, DTOs
│   └── repository/      # Repository implementations
├── domain/
│   ├── model/           # Domain entities
│   ├── repository/      # Repository interfaces
│   └── usecase/         # Use cases
└── presentation/
    ├── products/        # Product list + detail screens
    ├── cart/            # Cart screen
    └── auth/            # Login / register screens
```

---

## Getting Started

### Prerequisites

- Android Studio Hedgehog (2023.1.1) or newer
- JDK 17+
- Android SDK 35+

### Steps

1. Clone the repository

   ```bash
   git clone https://github.com/bavlymo1/Fake-Store-Sprints.git
   cd Fake-Store-Sprints
   ```

2. Open the project in Android Studio
3. Sync Gradle
4. Run on an emulator or physical device

> Uses the public [Fake Store API](https://fakestoreapi.com/) — no API key required.

---

## Running Tests

```bash
./gradlew test
```

ViewModel tests are in `app/src/test/`.

---

## Contributing

1. Fork this repository
2. Create a feature branch: `git checkout -b feature/your-feature`
3. Commit: `git commit -m "feat: add some feature"`
4. Open a Pull Request

---

## License

This project is open source for learning and demonstration purposes.

---

Made by [Bahy Mohy](https://github.com/bavlymo1) | [LinkedIn](https://www.linkedin.com/in/bahy-mohy-0b5ab6407/)
