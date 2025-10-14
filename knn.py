from sklearn.neighbors import KNeighborsClassifier
from sklearn.model_selection import train_test_split
from sklearn.datasets import load_iris
import numpy as np
import matplotlib.pyplot as plt

# Load dataset
irisData = load_iris()
X = irisData.data
y = irisData.target

# Split dataset into train and test sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size = 0.2, random_state=42)

# Arrays to store accuracy for different K values
neighbors = np.arange(1, 9)
train_accuracy = np.empty(len(neighbors))
test_accuracy = np.empty(len(neighbors))

# Evaluate K-NN for different K values
for i, k in enumerate(neighbors):
    knn = KNeighborsClassifier(n_neighbors=k)
    knn.fit(X_train, y_train)
    train_accuracy[i] = knn.score(X_train, y_train)
    test_accuracy[i] = knn.score(X_test, y_test)

# Train final model with selected K
knn = KNeighborsClassifier(n_neighbors=7)
knn.fit(X_train, y_train)

# Predictions
predictions = knn.predict(X_test)
print("Predicted classes for test data:", predictions)
print("Test set accuracy:", knn.score(X_test, y_test))

# Plot accuracy vs K
plt.plot(neighbors, test_accuracy, label='Testing dataset Accuracy')
plt.plot(neighbors, train_accuracy, label='Training dataset Accuracy')
plt.legend()
plt.xlabel('n_neighbors (K)')
plt.ylabel('Accuracy')
plt.title('K-NN Accuracy for different K values')
plt.show()
