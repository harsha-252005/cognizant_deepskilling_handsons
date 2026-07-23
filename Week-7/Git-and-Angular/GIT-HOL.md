# Git HOL 1–5

1. Configure identity: `git config --global user.name "Your Name"` and `git config --global user.email "you@example.com"`.
2. Inspect and stage: `git status`, then `git add <files>`.
3. Commit: `git commit -m "Complete Java FSE weeks 1 to 7"`.
4. Work with branches: `git switch -c feature/week-7`, then merge through a reviewed pull request.
5. Push only after verifying the remote: `git remote -v`, then `git push -u origin <branch>`.

Never use `git add .` until `git status` confirms there are no generated or unrelated files.
