#!/bin/bash

# Navigate to each submodule, update to latest main/master, and pull
cd devskill-api
git checkout main  # Use 'master' if that's the branch name
git pull origin main
cd ..

cd devSkill-ui
git checkout master  # Use 'main' if that's the branch name
git pull origin master
cd ..

# Stage and commit the updated submodules in the parent repo
git add devskill-api devSkill-ui
git commit -m "Update submodules to latest commits on main branches"
git push origin main  # Use 'master' if that's the parent repo's branch