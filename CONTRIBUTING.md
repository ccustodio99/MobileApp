# 🤝 Contributing to Level Up @ LCCD

Thank you for considering contributing! 🎉 This project is both a learning platform and a mission-driven app for engaging SHS students and promoting BSCS/BSIS programs at LCCD. We welcome contributions from faculty, students, alumni, and open-source enthusiasts.

---

## 📌 How to Contribute
1. **Fork** the repository.  
2. **Clone** your fork locally.  
   ```bash
   git clone https://github.com/<your-username>/MobileApp.git
   ```
3. Create a new branch for your changes:  
   ```bash
   git checkout -b feat/<short-description>
   ```
4. Make your changes (code, docs, tests, etc.).  
5. Run **lint and tests** before committing.  
6. Commit using **Conventional Commits** format.  
7. Push your branch and open a **Pull Request (PR)**.  

---

## 📜 Commit Message Guidelines
We follow **Conventional Commits**:
```
<type>(optional scope): <short summary>
```

**Types:**
- `feat`: New feature
- `fix`: Bug fix
- `docs`: Documentation changes
- `style`: Formatting, no code changes
- `refactor`: Code restructuring without changing behavior
- `test`: Adding or fixing tests
- `chore`: Build or CI-related changes

**Example:**
```
feat(quests): add offline caching for daily quests
fix(auth): resolve crash on login when Firebase is unavailable
docs(readme): update installation instructions
```

---

## ✅ Pull Request Checklist
Before submitting, please ensure:
- [ ] Code compiles without errors.  
- [ ] Lint passes (`./gradlew lint`).  
- [ ] Tests pass (`./gradlew test`).  
- [ ] UI changes include **screenshots** in the PR description.  
- [ ] Documentation updated if necessary (README, module docs).  
- [ ] PR title follows **Conventional Commits**.

---

## 🧪 Testing
Run unit and instrumentation tests locally:
```bash
./gradlew test
./gradlew connectedAndroidTest
```

We aim for **60%+ coverage**. Contributions that improve test coverage are highly valued.

---

## 🎨 Code Style
- **Kotlin:** Use `ktlint` + Android Studio’s built-in formatter.  
- **Architecture:** Follow MVVM with clear separation (`ui`, `domain`, `data`).  
- **Naming:** Meaningful, consistent, and descriptive.  
- **Comments:** Only where logic is not obvious; prefer self-documenting code.  

---

## 🌱 Augustinian Values in Contributions
- **Unity:** Collaborate respectfully; review others’ work with empathy.  
- **Charity:** Prioritize features that serve learners and the community.  
- **Truth:** Be transparent and honest in code and communication.  

---

## 📢 Community
- Discussions: Use GitHub Issues/Discussions for questions and feature requests.  
- Bugs: Report with steps, screenshots, and logs.  
- Enhancements: Submit as feature requests before large PRs.  

---

## 📄 License
By contributing, you agree that your contributions will be licensed under the MIT License.

---

> *Every contribution helps us form Christ-centered, socially responsible, and tech-empowered learners. ✝️🇵🇭🌿*

