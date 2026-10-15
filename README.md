# GitHub Projects Feature Spike

This repository is a practical spike for evaluating **GitHub Projects** through a small Java delivery scenario.

The repository is intentionally simple. The Java application provides realistic engineering work that can be planned, implemented, tested, reviewed, and completed through GitHub Issues, pull requests, Project fields, saved views, dependencies, and built-in workflows.

## Spike objectives

The spike evaluates whether GitHub Projects can support:

- backlog and iteration planning;
- Table, Board, and Roadmap views over the same work items;
- Project-specific planning metadata through custom fields;
- parent Issues and sub-issues;
- native `blocked by` and `blocking` relationships;
- built-in workflows and label-based automatic intake;
- Issue-to-branch-to-pull-request traceability;
- high-level communication through Insights and Project Updates;
- a controlled lifecycle for completed and archived work.

## Evaluation questions

1. Can one Project dataset support different planning and execution perspectives?
2. Can repository Issues and pull requests remain the source of truth?
3. Can sub-issues represent a useful work breakdown?
4. Can native dependencies make blocked work visible?
5. Can built-in workflows reduce manual Project maintenance?
6. Can Java changes be traced from an Issue to a merged pull request and Project completion?
7. Can Roadmap, Insights, and Project Updates improve stakeholder communication?

## Scope

### Included

- GitHub Issues and pull requests
- GitHub Project fields
- Table, Board, and Roadmap layouts
- Saved Project views and filters
- Iterations
- Parent Issues and sub-issues
- Issue dependencies
- Built-in Project workflows
- Repository auto-add
- Linked pull requests
- Insights and charts
- Project Updates
- Archiving and cleanup
- A small Java 17 Maven application
- JUnit 5 tests

### Excluded

- Company repository configuration
- Organization-wide rollout
- Production deployment
- Database or external service integration
- REST API or user interface development
- Spring Boot
- Custom GitHub Actions or GraphQL automation
- Individual productivity measurement

## Java mini-application

The application models a minimal task workflow.

```text
spike-github-projects/
├── pom.xml
├── README.md
└── src/
    ├── main/java/com/esfpoi1/githubprojects/task/
    │   ├── Task.java
    │   ├── TaskStatus.java
    │   └── TaskService.java
    └── test/java/com/esfpoi1/githubprojects/task/
        ├── TaskTest.java
        └── TaskServiceTest.java
```

### Technology baseline

- Java 17
- Maven
- JUnit Jupiter
- In-memory storage only

### Domain behaviour

`TaskStatus` contains:

```text
TODO
IN_PROGRESS
DONE
```

A `Task`:

- has a UUID identifier;
- has a non-blank title;
- starts in `TODO`;
- can transition to `IN_PROGRESS`;
- can transition to `DONE`.

`TaskService` supports:

- `create`
- `findById`
- `findAll`
- `start`
- `complete`

## Build and test

Prerequisites:

- JDK 17
- Maven 3.x

Run the complete test suite:

```bash
mvn test
```

Build the project:

```bash
mvn clean verify
```

## GitHub Project operating model

### Source-of-truth rule

Repository Issues and pull requests are the durable work records. Native GitHub metadata remains authoritative for:

- Issue state;
- assignees;
- labels;
- repository;
- parent/sub-issue relationships;
- dependencies;
- linked pull requests.

Project fields add planning context and must not unnecessarily duplicate native metadata.

### Project fields

| Field | Type | Values or usage |
|---|---|---|
| Status | Single select | Inbox, Backlog, Ready, In Progress, In Review, Done |
| Priority | Single select | P0 Critical, P1 High, P2 Normal, P3 Low |
| Effort | Number | 1, 2, 3, 5, 8 |
| Iteration | Iteration | Time-boxed delivery planning |
| Start date | Date | Planned start |
| Target date | Date | Single source for target timing |
| Workstream | Single select | Configuration, Automation, Java Delivery, Testing, Integration, Documentation, Presentation |
| Risk | Single select | None, Attention, Blocked |

The field names, options, and values above are **spike conventions**, not mandatory GitHub Projects standards.

### Status definitions

- **Inbox**: captured but not triaged.
- **Backlog**: accepted but not committed.
- **Ready**: sufficiently defined and not blocked.
- **In Progress**: active implementation or investigation.
- **In Review**: awaiting code review or validation.
- **Done**: the Definition of Done is satisfied.

### Saved views

| View | Layout | Purpose |
|---|---|---|
| 01 - Triage | Table | Find items with incomplete planning metadata |
| 02 - Backlog | Table | Prioritize incomplete work |
| 03 - Current Iteration | Board | Operate committed work by Status |
| 04 - Roadmap | Roadmap | Show meaningful date-based sequencing |
| 05 - My Work | Table | Focus on assigned incomplete work |
| 06 - Recently Done | Table | Review completed evidence before archiving |

### Working agreements

- Every accepted item has a Status, Priority, Workstream, and assignee.
- Iteration is assigned only after work is committed.
- Target date has one meaning and one storage location.
- Native dependencies are authoritative for blocked work.
- The `blocked` label and `Risk = Blocked` are optional spike signals for additional visibility.
- Deterministic bookkeeping can be automated.
- Priority, scope, risk, and delivery decisions remain human decisions.
- Saved views answer recurring operational questions.
- Completed items remain in `Recently Done` until evidence has been captured.

## Planned work breakdown

The parent spike Issue contains sub-issues for:

1. Project fields and working agreements
2. Table, Board, and Roadmap views
3. Built-in workflows
4. Maven application bootstrap
5. Task domain model
6. In-memory Task service
7. Unit-test completion
8. Issue-to-pull-request traceability
9. Findings and presentation preparation

Actual Issue numbers are assigned by GitHub. Dependencies should be configured using the native Issue **Relationships** controls after the Issues exist.

## Planned dependency chain

```text
Maven bootstrap
    ↓
Task domain model
    ↓
Task service
    ↓
Unit-test completion
    ↓
Issue-to-PR traceability
    ↓
Findings and presentation
```

The traceability evaluation also depends on the built-in workflow experiment being complete.

## Definition of Done

An implementation Issue is Done when:

- its acceptance criteria are satisfied;
- required tests pass;
- code review is complete;
- the pull request is merged when applicable;
- the linked Issue is closed correctly;
- Project status behaviour has been verified;
- findings or evidence have been recorded when required;
- documentation is updated.

The overall spike is Done when:

- all required sub-issues are complete;
- fields, views, hierarchy, dependencies, workflows, Roadmap, Insights, and Updates have been evaluated;
- automatic and manual transitions are distinguished;
- limitations are documented;
- an enterprise-pilot recommendation is available;
- presentation evidence has been captured.

## Pull request convention

Branch naming used by this spike:

```text
spike/<issue-number>-<short-description>
feature/<issue-number>-<short-description>
test/<issue-number>-<short-description>
```

This is a spike convention, not a GitHub Projects requirement.

Pull requests should include:

```markdown
## Purpose

Implement the change described by the linked Issue.

## Validation

- [ ] `mvn test` passes.
- [ ] Acceptance criteria are satisfied.
- [ ] Project Status is `In Review`.
- [ ] Evidence or observations are recorded.

Closes #<ISSUE_NUMBER>
```

## Evidence to capture

- Project overview and README
- Project fields
- All six saved views
- Parent Issue and sub-issue progress
- Native dependencies
- Workflow configuration
- Auto-add result
- Linked pull requests
- Passing Maven tests
- Roadmap
- Insights charts
- Project Update
- Recently Done and archive behaviour

## Expected outcome

The spike should produce an evidence-based recommendation for or against a controlled, organization-owned GitHub Projects pilot. The recommendation should identify:

- which native capabilities were validated;
- which conventions were introduced by the spike;
- which operations remained manual;
- which governance decisions are required;
- which behaviours still need validation in an organization-owned Project.

## References

- [GitHub Projects documentation](https://docs.github.com/en/issues/planning-and-tracking-with-projects)
- [Best practices for Projects](https://docs.github.com/en/issues/planning-and-tracking-with-projects/learning-about-projects/best-practices-for-projects)
- [About Projects](https://docs.github.com/en/issues/planning-and-tracking-with-projects/learning-about-projects/about-projects)
- [Adding sub-issues](https://docs.github.com/en/issues/tracking-your-work-with-issues/using-issues/adding-sub-issues)
- [Creating issue dependencies](https://docs.github.com/en/issues/tracking-your-work-with-issues/using-issues/creating-issue-dependencies)
- [Customizing Project views](https://docs.github.com/en/issues/planning-and-tracking-with-projects/customizing-views-in-your-project)
- [Understanding Project fields](https://docs.github.com/en/issues/planning-and-tracking-with-projects/understanding-fields)
- [Using built-in automations](https://docs.github.com/en/issues/planning-and-tracking-with-projects/automating-your-project/using-the-built-in-automations)
- [About Insights for Projects](https://docs.github.com/en/issues/planning-and-tracking-with-projects/viewing-insights-from-your-project/about-insights-for-projects)
- [Sharing Project updates](https://docs.github.com/en/issues/planning-and-tracking-with-projects/sharing-project-updates)
