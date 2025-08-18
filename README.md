# 🎮 Level Up @ LCCD  
**Gamified Mobile App for SHS Engagement & BSCS/BSIS Recruitment**

---

## 📑 Table of Contents
1. [Overview](#-overview)
2. [Features](#-features)
3. [Tech Stack](#-tech-stack)
4. [Installation](#-installation)
5. [How It Works](#-how-it-works)
6. [Detailed Features & Modules](#-detailed-features--modules)
7. [Roadmap](#-roadmap)
8. [Augustinian Values Integration](#-augustinian-values-integration)
9. [License](#-license)
10. [Contributors](#-contributors)
11. [Contact](#-contact)

---

## 📌 Overview
Level Up @ LCCD is a **Kotlin + Jetpack Compose** Android application designed to:
- **Engage** Senior High School students through gamified learning activities.
- **Educate** them on career opportunities in **BS Computer Science (BSCS)** and **BS Information Systems (BSIS)**.
- **Encourage** enrollment at La Consolacion College Daet (LCCD) via interactive content, challenges, and in-app calls to action.

---

## 🎯 Features
- **Daily Quests:** Quick logic and coding challenges.
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
- **Analytics:** Custom logger (Firebase-ready)
- **Optional Backend:** Firebase / REST API

---

## 📲 Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/your-org/level-up-lccd.git
   ```
2. Open in **Android Studio** (Arctic Fox or newer).
3. Sync Gradle and install dependencies.
4. Run the app on an Android device or emulator (API 24+).

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
*(Full breakdown of architecture, modules, and functionality for developers.)*

### 0) Roles & Personas
- **Student (SHS)** – Plays quests, explores careers, shares referrals, taps Apply.
- **Admissions/Marketing** – Views engagement stats, runs promos, tracks referrals.
- **Faculty/Content Curator** – Authors quests, values stories, career cards.

### 1) App Architecture
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

### 2) Core Modules
- **Onboarding & Profile:** Nickname, school, consent.
- **Home & Progress HUD:** Points, streak, daily quest.
- **Logic & Coding Quests:** MCQs, code prediction, bug fixing.
- **Cybersecurity/Data Quests:** Track-specific mini-games.
- **Values Quests:** Narrative missions based on Unity, Charity, Truth.
- **Career Explorer:** BSCS/BSIS cards with links.
- **Leaderboard:** Local or cloud ranking.
- **Referrals & Deep Links:** Invite friends, earn rewards.
- **Apply/Inquiry Funnel:** Direct link to admissions.
- **Notifications:** Streak reminders, events.

### 3) Data & Storage
- **Local:** DataStore (progress, profile).
- **Cloud:** Firebase/REST for leaderboards, referrals, events.

### 4) Analytics
- **Core Events:** `quest_completed`, `career_viewed`, `apply_tapped`, etc.
- **Dashboards:** Track engagement by school, topic, and conversion rates.
- **Privacy:** Opt-in analytics; anonymized data.

### 5) API Contracts (if using REST)
Example:
```
POST /api/inquiries
body: { name, contact, schoolCode, interestTrack }
```

### 6) Non-Functional Requirements
- Offline-first questing.
- Accessibility (contrast, TalkBack).
- Content safety (nickname filters).

### 7) Roadmap
1. MVP: Home, Logic Quests, Career Cards, Leaderboard.
2. Growth: Referrals, Firebase backend, analytics dashboard.
3. Depth: Values Quests, Cyber/Data packs, push notifications.

---

## 📈 Roadmap
- [ ] Firebase backend for leaderboards and referrals
- [ ] Dynamic link handling for referral codes
- [ ] Expanded “Values Quests” library
- [ ] Integration with LCCD’s admissions CRM

---

## 🏫 Augustinian Values Integration
- **Unity:** Group challenges, shared leaderboards.
- **Charity:** Service-themed quests.
- **Truth:** Ethical decision-making prompts.

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
