# Progress Report (01 May 2018)
## Overview
This milestone has been building off of findings reported during Milestone 2. For the final Milestone, Project-2501 has explored and implemented Proof-of-Concept code using interceptors. Our deliverables include findings on the ability to view variable (specifically, String) contents that were allocated by the Java Virtual Machine during execution of an application and improperly sanitized before being de-allocated. We explored different options of remediating this problem, including method or class interceptors to invoke specific functions with specific triggers or intervals, among other coding practices. Overall, this research will help the computer science and information security worlds better understand best practices around sensitive data handling within applications written using higher-level languages.

## Outcomes
Project 2501 has numerous proof-of-concept applications that properly demonstrate the pitfalls of relying solely on Oracle's Java Virtual Machine to handle allocation of variables when sensitive data must be processed. This project also includes proof-of-concept source code to demonstrate the proper handling of user-entered information when privacy is concerned. Our Milestone documents and presentations include referenced recommendations for handling sensitive information.

Milestone outcomes:
* A Presentation documenting the efforts of this team throughout the semester
* Documented source-code showing proof-of-concept exploitability and remediation
* Markdown-formatted report documents outlining the methodologies of this team throughout the project.

## Hinderances

As with many projects, group coordination and finding time to meet was a significant challenge for this team. With a lack of organized meetings, team coordination was, at times, absent, and team members struggled to feel confident in the progress of the project as a whole. Additionally, team members all had significant external obligations, meaning that, throughout the semester, individual efforts waxed and waned, causing frustration among all team members. Luckily, strong leadership was able to pull us together and set out times for us to get our much-needed work and collaboration done.  Additionally, this team suffered from a lack of well-researched reports in this area. Though many reports, write-ups, and journal articles documented *how* Oracle's JVM handled memory management (and included reccomendations for password management/user authentication), very little prior work is readily available about other sensitive data pitfalls within the JVM, and even less is available on the impact of this concern. However, the lack of prior work only makes us more confident in the value of our research and the importance of its conclusions and recommendations.

