# 🎮 Level Up @ LCCD  
**Gamified Mobile App for SHS Engagement & BSCS/BSIS Recruitment**

[![Build](https://github.com/ccustodio99/MobileApp/actions/workflows/ci.yml/badge.svg)](../../actions)
[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)
[![Made with Kotlin](https://img.shields.io/badge/Kotlin-1.9-blue)](#)
[![LCCD Values](https://img.shields.io/badge/Augustinian-Unity%20%7C%20Charity%20%7C%20Truth-ff69b4)](#)

---

## 📑 Table of Contents
1. [Overview](#-overview)  
2. [Features](#-features)  
3. [Tech Stack](#-tech-stack)  
4. [Architecture](#-architecture)  
5. [Installation](#-installation)  
6. [How It Works](#-how-it-works)  
7. [Detailed Features & Modules](#-detailed-features--modules)  
8. [Roadmap](#-roadmap)  
9. [Augustinian Values Integration](#-augustinian-values-integration)  
10. [Contributing](#-contributing)  
11. [Screenshots & Demo](#-screenshots--demo)  
12. [Non-Functional Requirements](#-non-functional-requirements)  
13. [License](#-license)  
14. [Contributors](#-contributors)  
15. [Contact](#-contact)

---

## 📌 Overview
Level Up @ LCCD is a **Kotlin + Jetpack Compose** Android application designed to:
- **Engage** Senior High School students through gamified learning activities.
- **Educate** them on career opportunities in **BS Computer Science (BSCS)** and **BS Information Systems (BSIS)**.
- **Encourage** enrollment at La Consolacion College Daet (LCCD) via interactive content, challenges, and in-app calls to action.

**Current Status:** 🎯 Alpha version (MVP features complete, preparing for beta testing).

---

## 🎯 Features
- **Daily Quests:** Rotating logic and coding challenges with instant feedback.
- **Career Explorer:** Interactive cards for BSCS and BSIS pathways.
- **Values Quests:** Story-based activities aligned with LCCD’s Augustinian values.
- **Leaderboards:** Friendly competition to boost engagement.
- **Referral System:** Share the app to earn bonus points.
- **Apply/Inquiry CTA:** One-tap access to LCCD admissions.

---

## 🛠 Tech Stack
- **Language:** Kotlin
- **UI Framework:** Jetpack Compose + Material 3
- **Navigation:** `androidx.navigation.compose`
- **State Management:** ViewModel + Kotlin Flows
- **Local Data:** DataStore
- **Analytics:** Firebase-ready custom logger
- **Optional Backend:** Firebase / REST API

---

## 🏗 Architecture
- **Presentation:** Compose + Material 3 UI.  
- **Domain:** Business logic, validators.  
- **Data:** Repositories, DataStore/Firebase.  

```
app/
  ui/...
  domain/...
  data/...
  di/...
  util/...
```

---

## 📲 Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/ccustodio99/MobileApp.git
   ```
2. Open in **Android Studio** (Arctic Fox or newer).  
3. Sync Gradle and install dependencies.  
4. Copy `.env.example` to `.env` and fill in the required keys (e.g., `FIREBASE_API_KEY`, `API_BASE_URL`).
5. Run the app on an Android device or emulator (API 24+).

### Running Tests
```bash
./gradlew lint
./gradlew test
```

---

## 📚 How It Works
1. **Home Screen** – Points, streaks, daily quest button.  
2. **Quest Screen** – Multiple-choice puzzles with feedback.  
3. **Career Screen** – Highlights BSCS/BSIS career tracks.  
4. **Leaderboard** – Displays top scorers.  
5. **Referral Share** – Share code via social apps for rewards.  
6. **Analytics** – Tracks engagement events.

---

## 🔎 Detailed Features & Modules
- **Onboarding & Profile:** Nickname, school, consent.  
- **Logic & Coding Quests:** MCQs, code prediction, bug fixing.  
- **Values Quests:** Narrative missions based on Unity, Charity, Truth.  
- **Cybersecurity/Data Quests:** Track-specific mini-games.  
- **Leaderboards:** Local or cloud ranking.  
- **Notifications:** Streak reminders, events.  
- **Apply/Inquiry Funnel:** Direct link to admissions.  

### Daily Quests Example
```json
{
  "id": "logic-001",
  "question": "What is 2 + 2?",
  "options": ["3", "4", "5"],
  "answerIndex": 1,
  "points": 10
}
```

---

## 📈 Roadmap
- [x] MVP: Home, Logic Quests, Career Cards, Leaderboard  
- [ ] Firebase backend for leaderboards and referrals  
- [ ] Dynamic link handling for referral codes  
- [ ] Expanded “Values Quests” library  
- [ ] Integration with LCCD’s admissions CRM  
- [ ] Accessibility & localization testing

---

## 🏫 Augustinian Values Integration
- **Unity:** Group challenges, shared leaderboards.  
- **Charity:** Service-themed quests.  
- **Truth:** Ethical decision-making prompts.  
- **Christ-centered:** Activities that inspire faith-driven reflection.  
- **Nationalist:** Promotes Filipino identity and tech empowerment.  
- **Ecological Stewardship:** Quests on sustainability and eco-awareness.  
- **Committed Service:** Encourages applying skills to help the community.  

---

## 🤝 Contributing
See [CONTRIBUTING.md](CONTRIBUTING.md) for details. Quick guide:  
- Branch: `feat/<short-name>` or `fix/<short-name>`  
- Follow conventional commits (e.g., `feat: add offline sync`)  
- Include screenshots for UI changes  
- Run lint/tests before submitting PR

---

## 📸 Screenshots & Demo
<p align="center">
  <img src="docs/screen1.png" width="200" />
  <img src="docs/screen2.png" width="200" />
</p>

[▶ Watch Demo Video](https://youtu.be/your-demo-link)

---

## ⚙️ Non-Functional Requirements
- **Offline-first questing** (play anywhere).  
- **Accessibility**: High-contrast, TalkBack compatible.  
- **Performance**: <2s startup on mid-range devices.  
- **Privacy**: Opt-in analytics, anonymized engagement data.  
- **Content safety**: Nickname filters, age-appropriate challenges.  

---

## 📜 License
Licensed under the MIT License.

---

## 👥 Contributors
- **Prof. Christian Custodio** – Project Lead  
- BSCS/BSIS Student Developers – Development  
- LCCD Admissions & Marketing – Content  

---

## 📧 Contact
- Email: `ccustodio@openit.com`  
- Website: [LCCD Official Site](https://lccd.edu)  

> Built with love, Unity, Charity, and Truth — shaping Christ-centered, service-driven learners through code. ✝️🇵🇭🌿

