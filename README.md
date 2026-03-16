Use Case 2: Room Search & Availability Check

Description:

This module allows guests to search available rooms without modifying inventory.

Data Structures Used:

HashMap<String, Integer>

HashMap<String, Double>

Key Concepts:

Read-only access to inventory

Defensive availability checks

Real-time availability display

Features:

Show available room types

Display pricing

Prevent booking of unavailable rooms

Flow:

Guest sends search request

        ↓
        
HashMap lookup

        ↓
        
Filter rooms with count > 0

        ↓
        
Display results

Benefits:

Fast response time

Accurate availability

Inventory remains unchanged
