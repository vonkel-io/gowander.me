# 🧭 gowander

**Your collaborative, open-source travel planner. Never miss a booking or a bus again.**

[![License: AGPL v3](https://img.shields.io/badge/License-AGPL_v3-blue.svg)](https://www.gnu.org/licenses/agpl-3.0)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](https://github.com/vonkel-io/gowander/pulls)
<!-- [![Build Status](https://github.com/vonkel-io/gowander/actions/workflows/build.yml/badge.svg)](https://github.com/vonkel-io/gowander/actions) -->
<!-- [![Discord](https://img.shields.io/discord/your-discord-invite-code.svg?label=Discord&logo=discord&color=7289DA)](https://discord.gg/your-invite) -->

> **Project in Embryonic Development** • We are laying the foundations. Your contribution is especially valuable now!

## ✨ The Problem We Solve

Planning a complex trip is chaotic. Booking links are scattered across emails, time zones get mixed up, and transport tickets never seem to align with hotel dates... **Ever bought a flight to the wrong country?** We have, too.

**gowander** is your personal travel organizer. It centralizes **your entire itinerary, bookings, documents, and budget** in one place, helping you foresee and resolve conflicts *before* they ruin your vacation. Enjoy more relaxed days with everything you need on your phone, right when you need it.

## 🎯 Target Audience

*   **Independent Travelers** planning longer vacations or complex itineraries.
*   **Groups of Friends or Family** organizing a trip together.
*   **Digital Nomads** who need to manage the logistics of life and work on the move.
*   *(Future) Travel Agencies** looking to offer customizable packages and itineraries through the platform.

## 🚀 MVP (Version 1.0) - "The Friends' Trip"

Our first major goal is to support a real trip for 5 people. The MVP will enable:

1.  **Collaborative Itinerary:** Create and share a day-by-day itinerary with times, locations, and notes.
2.  **Booking & Document Management:** Attach flight confirmations, hotel bookings, tickets, and reservations to each day of the itinerary. View everything in a consolidated dashboard.
3.  **Group Budget Control:** Set a trip budget and log expenses, with planned integration for digital wallets (Apple/Google Wallet) for easy access to tickets and boarding passes.
4.  **Smart Alerts:** Notifications for schedule conflicts, upcoming check-ins, or required documents.

## 🏗️ Project Architecture

The gowander ecosystem is built as a collection of specialized repositories:

| Repository | Purpose | Primary Tech Stack |
| :--- | :--- | :--- |
| **[gowander](https://github.com/vonkel-io/gowander)** (You are here) | **Core Backend API** | Kotlin, Micronaut, PostgreSQL |
| **[gowander-app](https://github.com/vonkel-io/gowander-app)** | Mobile Application (Future) | To be defined (React Native / Flutter) |
| **[gowander-web](https://github.com/vonkel-io/gowander-web)** | Web Dashboard / Admin Panel | React (TypeScript), Vite, Tailwind CSS |
| **[gowander-infra](https://github.com/vonkel-io/gowander-infra)** | Infrastructure as Code | Docker, docker-compose, CI/CD |

> **Note:** The initial infrastructure is fully containerized with Docker, allowing any contributor to spin up the local development environment with a single command. Each repository contains its own detailed setup instructions.

## 📋 Project Status & Roadmap

We are in the **embryonic phase**, designing the architecture and building the first endpoints and components.

*   **`main` branch:** Stable (when it exists).
*   **`develop` branch:** Active integration branch.
*   **Public Roadmap:** Our high-level roadmap and task backlog are managed in the [**Vonkel Open Source Project Board**](https://github.com/orgs/vonkel-io/projects/1).

Our governance is open: technical decisions are made through **discussion in GitHub Issues and voting** among active contributors.

## 🚀 How to Contribute

We love your energy! These are the areas where we need the most help **right now**:

1.  **💻 Code:** Kotlin (Micronaut) and React (TypeScript).
2.  **🎨 UI/UX Design:** Prototypes, components, visual identity.
3.  **📚 Documentation:** Improving READMEs, setup guides, architecture docs.
4.  **🐛 Testing & QA:** Writing unit and integration tests, reporting bugs.
5.  **💡 Ideas & Discussion:** Participate in Issues with suggestions and feedback.

### First Steps for Developers

1.  **Explore the Issues:** Look for issues tagged with `good first issue` or `help wanted`.
2.  **Choose a Repository:** Decide which part of the stack you want to contribute to (API, Web, etc.).
3.  **Follow the Setup Guide:** Each repository has its own `CONTRIBUTING.md` and `README.md` with detailed instructions for running the project locally.
4.  **Fork & Branch:** Fork the repository, create a branch for your feature (`feature/your-feature-name`) or fix (`fix/issue-description`).
5.  **Follow Commit Conventions:** We use semantic prefixes:
    *   `feat:` New feature
    *   `fix:` Bug fix
    *   `docs:` Documentation changes
    *   `style:` Code style changes (formatting, missing semi-colons, etc.)
    *   `refactor:` Code refactoring (no behavior change)
    *   `test:` Adding or correcting tests
    *   `chore:` Build task updates, config changes, etc.
6.  **Open a Pull Request (PR):** Describe your changes clearly and reference the related issue.

## 📄 License

This project is licensed under the **GNU Affero General Public License v3.0 (AGPL-3.0)**.

This is a strong copyleft license. It means:
*   You are free to use, modify, and distribute this software.
*   **If you use this software (or a modified version) to provide a service over a network (e.g., a SaaS), you must make the complete source code of that service available to its users.**
*   Derivative works must be licensed under the same terms.

See the [LICENSE](LICENSE) file for the full text.

## 🤝 Acknowledgements

*   Developed with ❤️ by [Vonkel](https://vonkel.io).
*   Inspired by the real-life travel pains of all contributors.
*   Thanks to all [contributors](https://github.com/vonkel-io/gowander/graphs/contributors) helping to build this dream.

---

**Next Steps?** Star ⭐ this repository, join the discussion in the Issues, and let's build the world's best open-source travel tool together!

### 🧳 Related Repositories

*   **[gowander-app](https://github.com/vonkel-io/gowander-app)** - The mobile application (Future)
*   **[gowander-web](https://github.com/vonkel-io/gowander-web)** - The web dashboard
*   **[gowander-infra](https://github.com/vonkel-io/gowander-infra)** - Infrastructure and deployment