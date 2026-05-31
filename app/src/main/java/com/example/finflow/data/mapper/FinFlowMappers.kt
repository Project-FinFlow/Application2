package com.example.finflow.data.mapper

import com.example.finflow.data.dto.CategoryDto
import com.example.finflow.data.dto.GoalDto
import com.example.finflow.data.dto.LogDto
import com.example.finflow.data.dto.MovementDto
import com.example.finflow.data.dto.UserDto
import com.example.finflow.data.local.entity.CategoryEntity
import com.example.finflow.data.local.entity.GoalEntity
import com.example.finflow.data.local.entity.LogEntity
import com.example.finflow.data.local.entity.MovementEntity
import com.example.finflow.data.local.entity.UserEntity
import com.example.finflow.ui.data.CategoryItem
import com.example.finflow.ui.data.GoalItem
import com.example.finflow.ui.data.LogItem
import com.example.finflow.ui.data.Movement
import com.example.finflow.ui.data.MovementKind
import com.example.finflow.ui.data.UserItem

fun MovementDto.toEntity() = MovementEntity(id, description, category, date, value, kind)

fun MovementEntity.toDto() = MovementDto(
    id = id,
    description = description.orEmpty(),
    category = category.orEmpty(),
    date = date.orEmpty(),
    value = value.orEmpty(),
    kind = kind.orEmpty()
)

fun Movement.toDto() = MovementDto(
    id = id,
    description = description,
    category = category,
    date = date,
    value = value,
    kind = kind.name
)

fun MovementDto.toUiModel() = Movement(
    id = id,
    description = description,
    category = category,
    date = date,
    value = value,
    kind = kind.toMovementKind()
)

fun CategoryDto.toEntity() = CategoryEntity(id, name, description, kind)

fun CategoryEntity.toDto() = CategoryDto(
    id = id,
    name = name.orEmpty(),
    description = description.orEmpty(),
    kind = kind.orEmpty()
)

fun CategoryItem.toDto() = CategoryDto(
    id = id,
    name = name,
    description = description,
    kind = kind.name
)

fun CategoryDto.toUiModel() = CategoryItem(
    id = id,
    name = name,
    description = description,
    kind = kind.toMovementKind()
)

fun GoalDto.toEntity() = GoalEntity(id, name, current, target, dueDate, progress)

fun GoalEntity.toDto() = GoalDto(
    id = id,
    name = name.orEmpty(),
    current = current.orEmpty(),
    target = target.orEmpty(),
    dueDate = dueDate.orEmpty(),
    progress = progress
)

fun GoalItem.toDto() = GoalDto(
    id = id,
    name = name,
    current = current,
    target = target,
    dueDate = dueDate,
    progress = progress
)

fun GoalDto.toUiModel() = GoalItem(
    id = id,
    name = name,
    current = current,
    target = target,
    dueDate = dueDate,
    progress = progress
)

fun UserDto.toEntity() = UserEntity(email, initials, name, role)

fun UserEntity.toDto() = UserDto(
    email = email.orEmpty(),
    initials = initials.orEmpty(),
    name = name.orEmpty(),
    role = role.orEmpty()
)

fun UserItem.toDto() = UserDto(
    email = email,
    initials = initials,
    name = name,
    role = role
)

fun UserDto.toUiModel() = UserItem(
    initials = initials,
    name = name,
    email = email,
    role = role
)

fun LogDto.toEntity() = LogEntity(id, event, actor, date, status)

fun LogEntity.toDto() = LogDto(
    id = id,
    event = event.orEmpty(),
    actor = actor.orEmpty(),
    date = date.orEmpty(),
    status = status.orEmpty()
)

fun LogItem.toDto() = LogDto(
    id = id,
    event = event,
    actor = actor,
    date = date,
    status = status
)

fun LogDto.toUiModel() = LogItem(
    id = id,
    event = event,
    actor = actor,
    date = date,
    status = status
)

private fun String.toMovementKind(): MovementKind {
    return MovementKind.entries.firstOrNull { it.name.equals(this, ignoreCase = true) }
        ?: MovementKind.Despesa
}
