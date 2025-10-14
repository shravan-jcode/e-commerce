import tensorflow as tf
from tensorflow.keras.datasets import mnist
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense

# Load and preprocess data
(train_X, train_y), (test_X, test_y) = mnist.load_data()
train_X = train_X.reshape(-1, 28*28)/255.0
test_X = test_X.reshape(-1, 28*28)/255.0

# Build and train model
model = Sequential([Dense(128, activation='relu', input_shape=(28*28,)),
                    Dense(10, activation='softmax')])
model.compile(optimizer='adam', loss='sparse_categorical_crossentropy', metrics=['accuracy'])
model.fit(train_X, train_y, epochs=5, batch_size=32)

# Evaluate
loss, acc = model.evaluate(test_X, test_y)
print("Test accuracy:", round(acc, 3))
