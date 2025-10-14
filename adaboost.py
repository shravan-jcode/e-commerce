import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.ensemble import AdaBoostClassifier
import warnings
warnings.filterwarnings("ignore")

# Load dataset
file_path = "iris_dataset.csv"
data = pd.read_csv(file_path)

# Remove Id column if present
if 'Id' in data.columns:
    data = data.drop('Id', axis=1)

# Split features and target
x = data.iloc[:, :-1]
y = data.iloc[:, -1]

# Check dataset info
print("Shape of X:", x.shape, "Shape of y:", y.shape)
print("Number of classes:", y.nunique())
print("Distribution of classes:\n", y.value_counts())

# Split into training and validation sets
x_train, x_val, y_train, y_val = train_test_split(x, y, test_size=0.2, random_state=28)

# Train AdaBoost classifier
abd = AdaBoostClassifier()
abd_model = abd.fit(x_train, y_train)

# Evaluate performance
accuracy = abd_model.score(x_val, y_val)
print("Accuracy of AdaBoost on validation set:", accuracy)
