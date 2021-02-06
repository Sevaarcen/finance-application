# Git and GitHub Essentials

---
### Clone
```bash
git clone https://github.com/connellboyce/finance-application
```
- Clone the repository to your machine
- Initial requirement

---
### Branches
```bash
git checkout -b thisBranchIsNew
```
- Create a new branch
```bash
git checkout thisBranchExists
```
- Switch to existing branch
```bash
git branch -a
```
- List all branches
```bash
git branch
```
- Displays the current working branch
---
### Add
```bash
git add .
```
- Stages all changed files to be added to the main project
```bash
git add I-Am-An-Example-File
```
- Stages a specific file and not any others
---
### Commit
```bash
git commit
```
- Lets you put all staged files in a commit
- Add a title (Because you can only enter small amounts of text, make commits small and specific to one topic)
- Press "i" to begin typing
- To escape, press ESC and type ":wq!" to further the commit process or ":q!" to cancel.
---
### Push
```bash
git push origin Enter-Your-Current-Branch-Here
```
- Pushes changes from local machine's branch to the origin's (GitHub Console's) version of that branch. After a push, the work must be merged in the GitHub console.
---
### Pull
```bash
git pull
```
- Pulls the most recent version of the branch currently working on